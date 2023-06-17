pipeline {
    agent any

    // AWS 리전과 액세스 키 설정
    environment {
        AWS_REGION = 'ap-northeast-2'
        AWS_ACCESS_KEY_ID = credentials('BackEnd-AWS-ElasticBeanstalk') // AWS 액세스 키 ID (내 AWS IAM 계정정보)
        AWS_SECRET_ACCESS_KEY = credentials('BackEnd-AWS-ElasticBeanstalk-SecretKey') // 비밀 액세스 키 (IAM 계정 액세스 키 정보)
    }

    stages {
        // 단계: 소스 코드 체크아웃
        stage('Checkout') {
            steps {
                // AWS CodeCommit 소스 제어 설정
                withCredentials([string(credentialsId: 'BackEnd-AWS-CodeCommit', variable: 'AWS_CODECOMMIT_CREDENTIALS')]) {
                    sh '''
                        git config --global credential.helper '!aws --profile jenkins codecommit credential-helper $@'
                        git config --global credential.UseHttpPath true
                        git clone https://git-codecommit.ap-northeast-2.amazonaws.com/v1/repos/virtual-platform
                    '''
                }
                dir('virtual-platform') {
                    // Git 리포지토리에서 소스 코드 체크아웃
                    git branch: 'main', url: 'https://git-codecommit.ap-northeast-2.amazonaws.com/v1/repos/virtual-platform'
                }
            }
        }

        // 단계: 빌드
        stage('Build') {
            steps {
                // Gradle을 사용하여 애플리케이션 빌드
                sh 'gradle build'
            }
        }

        // 단계: 테스트
        stage('Test') {
            steps {
                // Gradle을 사용하여 테스트 실행
                sh 'gradle test'
            }
        }

        // 단계: AWS Elastic Beanstalk 초기화
        stage('Initialize EB CLI') {
            steps {
                // AWS Elastic Beanstalk CLI 초기화
                sh 'eb init --region $AWS_REGION'
            }
        }

        // 단계: AWS Elastic Beanstalk으로 배포
        stage('Deploy to AWS Elastic Beanstalk') {
            steps {
                // 배포 스크립트에 실행 권한 부여
                sh 'chmod +x deploy.sh'
                // 배포 스크립트 실행
                sh './deploy.sh'
            }
        }

        // 단계: 정리
        stage('Cleanup') {
            steps {
                // 빌드 후 불필요한 파일 삭제
                sh 'rm -rf build'
            }
        }
    }

    // post 섹션: 파이프라인 완료 후 실행되는 작업 정의
    post {
        always {
            // 작업 공간 정리
            cleanWs()
        }
        success {
            // 성공 메시지 출력
            echo 'Jenkins pipeline executed successfully!'
        }
        failure {
            // 실패 메시지 출력
            echo 'Jenkins pipeline execution failed!'
        }
    }
}
