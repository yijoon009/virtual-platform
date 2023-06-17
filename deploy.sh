#!/bin/bash

# AWS Elastic Beanstalk Application Name
EB_APPLICATION="meetup-backend"

# AWS Elastic Beanstalk Environment Name
EB_ENVIRONMENT="meetup-backend"

# Version label
VERSION_LABEL=$(date +%Y%m%d%H%M%S)

# Create a New Application Version in AWS Elastic Beanstalk
eb create $EB_ENVIRONMENT --version $VERSION_LABEL

# Update the Environment to the New Application Version
eb use $EB_ENVIRONMENT
