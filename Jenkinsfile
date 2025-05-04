pipeline {
    agent any

    stages {
        stage('Git') {
            steps {
                git 'https://github.com/espace2021/CRUDspringBoot' 
            }
        }
         stage('Build') {
            steps {
                echo 'Construction du projet Maven...'
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Maven Test') {
            steps {
                sh """mvn -version"""
            }
        }
    }
}
