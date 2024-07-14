pipeline {
    agent any
    environment {
        JIRA_SITE = 'https://monsitejira2024.atlassian.net/'
        JIRA_USER = 'sandrahammamitlili@gmail.com'  // Votre adresse e-mail utilisée pour Jira
        JIRA_API_TOKEN = 'ATATT3xFfGF0EkNFol1FcGH-jbxCjNYojvTMmN4wgmRshxlirpAE2mvWSs6-luvoZeX8MtmhLt8Gugc_5TTUcYk2ODb9T34MBuCyYr9k935Zi3rsDw0p2O1t_FAIz4hRMGUBPAMh4rxf0nf1iAxd8rUOWZDtXwCO5jAzxooMNqhU7xzpk__qTBA=B6F3957F'  // Votre jeton API Jira
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
         stage('Test Jira API') {
            steps {
                script {
                    def jiraIssueKey = "PROJ-2"
                    def jiraComment = "Test comment from Jenkins"
                    def response = httpRequest acceptType: 'APPLICATION_JSON',
                        contentType: 'APPLICATION_JSON',
                        httpMode: 'POST',
                        requestBody: """{
                            "body": "test from jenkins"
                        }""",
                        url: "https://monsitejira2024.atlassian.net/rest/api/2/issue/PROJ-2/comment",
                        authentication: 'jira-credentials'
                    echo "Response: ${response}"
                }
            }
        }
         stage('Update Jira') {
            steps {
                script {
                    def jiraIssueKey = "PROJ-2"
                    def jiraComment = "Build et déploiement réussis"
                    jiraAddComment site: "https://monsitejira2024.atlassian.net", idOrKey: jiraIssueKey, comment: jiraComment, credentialsId: 'jira-credentials'
                }
            }
        }
    }
    post {
        failure {
            script {
                def jiraIssueKey = "PROJ-2"
                def jiraComment = "Build ou déploiement échoué"
                jiraAddComment site: "https://monsitejira2024.atlassian.net", idOrKey: jiraIssueKey, comment: jiraComment, credentialsId: 'jira-credentials'
            }
        }
    }
}
