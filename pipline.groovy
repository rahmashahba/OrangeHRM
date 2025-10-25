pipeline {
    agent any

    stages {
        stage('Get Code') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/SalmaMamdouh12/WebScrapping.git'
            }
        }

        stage('Build Code') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/surefire-reports',
                        reportFiles: 'emailable-report.html',
                        reportName: 'Automation Exercise Report'
                ])
            }
        }
    }
}