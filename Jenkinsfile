pipeline {
    agent any

    stages {
        stage('Git') {
            steps {
                git 'https://github.com/espace2021/CRUDspringBoot' 
            }
        }
        stage('Maven Build') {
            steps {
                sh 'mvn clean package' 
            }
        }
        stage('Maven Test') {
            steps {
                sh """mvn -version"""
            }
        }
    }
}
