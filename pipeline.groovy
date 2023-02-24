pipeline {
    environment {
        IMAGE_NAME = "alpinehelloworld"
        IMAGE_TAG = "latest"
        STAGING = toto-staging
        PRODUCTION = toto-production
    }
    agent none
    stages {
        stage('Build image'){
            agent any
            steps{
                script{
                    sh 'docker build -t tonytdj/$IMAGE_NAME:$IMAGE_TAG .'
                }
            }
        } 
        stage('Run container based on build image'){
            agent any
            steps{
                script{
                    sh '''
                        docker run -d -p 80:5000 -e PORT=5000 --name $IMAGE_NAME tonytdj/$IMAGE_NAME:$IMAGE_TAG
                        sleep 5
                    '''
                }
            }
        }
        stage('Test image'){
            agent any
            steps{
                script{
                    sh '''
                        curl http://172.17.0.1 | grep -q "Hello world!"
                    '''
                }
            }
        }
        stage('Clean container'){
            agent any
            steps{
                script{
                    sh '''
                        docker stop $IMAGE_NAME
                        docker rm $IMAGE_NAME
                    '''
                }
            }
        }
        stage('Push image staging and deploy it'){
            when {
                    expression { GIT_BRANCH == 'origin/master'}
            }
            agent any
            steps{
                script{
                    sh '''
                        docker stop $IMAGE_NAME
                        docker rm $IMAGE_NAME
                    '''
                }
            }   
    }
}