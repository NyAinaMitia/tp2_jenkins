pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {

        stage('Check Docker') {
            steps {
                sh 'docker --version'
            }
        }

        stage('Build the application') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Unit Test Execution') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t triangle-app:1.0 .'
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([string(credentialsId: 'dockerhubpass', variable: 'dockerHubPass')]) {
                    sh 'docker login -u nyainamitia -p $dockerHubPass'
                    sh 'docker tag triangle-app:1.0 nyainamitia/triangle-app:1.0'
                    sh 'docker push nyainamitia/triangle-app:1.0'
                }
            }
        }
    }

    post {
        failure {
            emailext body: 'Ce Build $BUILD_NUMBER a echoue',
                     recipientProviders: [requestor()],
                     subject: 'Build echoue',
                     to: 'mitiarazafimanantsoa@gmail.com'
        }
    }
}