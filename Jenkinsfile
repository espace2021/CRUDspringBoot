pipeline {
    agent any
    environment {
        JIRA_SITE = 'https://monsite2024.atlassian.net'
        JIRA_USER = 'sandrahammamitlili@gmail.com'  // Votre adresse e-mail utilisée pour Jira
        JIRA_API_TOKEN = 'ATATT3xFfGF0GuMjsWOxjTEo6ZqLYhvSp2D6UlJjiQGdTR7PERbtmWhP-ZhzH1yiBw89qlzZ7TqC7sJHokPM334v2-Or6lwozq0TFHjw8Jt5TrP2xkjIrYuYM3s-jHnqHGj6ou-v0MULxvksNhAsPRaiXygNbPQ1UEg0crnKp1LeChszO27PTOE=BC24C324'  // Votre jeton API Jira
    }
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/espace2021/CRUDspringBoot', credentialsId: 'github-creds']]])
            }
        }
        stage('Build') {
            steps {
                bat 'mvnw.cmd clean package' // Utiliser bat pour exécuter des commandes sur Windows
            }
        }
        stage('Test') {
            steps {
                bat 'mvnw.cmd test' // Utiliser bat pour exécuter des commandes sur Windows
            }
        }
        stage('Update Jira') {
            steps {
                script {
                    def jiraIssueKey = "KAN-2"
                    def jiraComment = "Build et déploiement réussis"
                    jiraAddComment site: "https://monsite2024.atlassian.net/jira/software/projects/KAN/boards/1", idOrKey: jiraIssueKey, comment: jiraComment, credentialsId: 'jira-SandraHammami'
                }
            }
        }
    }
    post {
        failure {
            script {
                def jiraIssueKey = "KAN-2"
                def jiraComment = "Build ou déploiement échoué"
                jiraAddComment site: "https://monsite2024.atlassian.net/jira/software/projects/KAN/boards/1", idOrKey: jiraIssueKey, comment: jiraComment, credentialsId: 'jira-SandraHammami'
            }
        }
    }
}
