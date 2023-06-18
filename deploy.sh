#!/bin/bash

# AWS Elastic Beanstalk Application Name
EB_APPLICATION="meetup-spring-boot"

# AWS Elastic Beanstalk Environment Name
EB_ENVIRONMENT="meetup-spring-boot"

# Version label
VERSION_LABEL=$(date +%Y%m%d%H%M%S)

# Set the default environment
eb use $EB_ENVIRONMENT

# Create a New Application Version in AWS Elastic Beanstalk
eb deploy --version $VERSION_LABEL
