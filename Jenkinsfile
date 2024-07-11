pipeline {
    agent any
    environment {
        JIRA_SITE = 'https://monsite2024.atlassian.net/jira/software/projects/KAN/boards/1'
        JIRA_USER = ''
        JIRA_PASSWORD = ''
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/espace2021/CRUDspringBoot'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }
        stage('Deploy') {
            steps {
                sh './deploy.sh' // Script de déploiement
            }
        }
        stage('Update Jira') {
            steps {
                script {
                    def jiraIssueKey = "KAN-2" 
                    def jiraComment = "Build et déploiement réussis pour ${env.BUILD_ID}"
                    jiraAddComment site: env.JIRA_SITE, idOrKey: jiraIssueKey, comment: jiraComment
                }
            }
        }
    }
    post {
        failure {
            script {
                def jiraIssueKey = "KAN-2" 
                def jiraComment = "Build ou déploiement échoué pour ${env.BUILD_ID}"
                jiraAddComment site: env.JIRA_SITE, idOrKey: jiraIssueKey, comment: jiraComment
            }
        }
    }
}