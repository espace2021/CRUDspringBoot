pipeline {
    agent any
    environment {
        JIRA_SITE = 'https://monsite2024.atlassian.net'
        JIRA_USER = 'sandrahammamitlili@gmail.com' 
        JIRA_API_TOKEN = 'ATATT3xFfGF0GuMjsWOxjTEo6ZqLYhvSp2D6UlJjiQGdTR7PERbtmWhP-ZhzH1yiBw89qlzZ7TqC7sJHokPM334v2-Or6lwozq0TFHjw8Jt5TrP2xkjIrYuYM3s-jHnqHGj6ou-v0MULxvksNhAsPRaiXygNbPQ1UEg0crnKp1LeChszO27PTOE=BC24C324' 
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
                    jiraAddComment site: env.JIRA_SITE, idOrKey: jiraIssueKey, comment: jiraComment, credentialsId: 'jira-creds'
                }
            }
        }
    }
    post {
        failure {
            script {
                def jiraIssueKey = "KAN-2"
                def jiraComment = "Build ou déploiement échoué pour ${env.BUILD_ID}"
                jiraAddComment site: env.JIRA_SITE, idOrKey: jiraIssueKey, comment: jiraComment, credentialsId: 'jira-creds'
            }
        }
    }
}
