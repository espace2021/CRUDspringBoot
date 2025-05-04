pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'Maven 3' // Déclare le nom de l'installation Maven dans Jenkins
        JAVA_HOME = tool 'JDK 21'   // Déclare le nom de l'installation JDK dans Jenkins
        PATH = "${MAVEN_HOME}/bin:${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Clonage du dépôt Git...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Construction du projet Maven...'
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Tests') {
            steps {
                echo 'Exécution des tests...'
                sh 'mvn test'
            }

            post {
                always {
                    junit '**/target/surefire-reports/*.xml' // Rapports de tests JUnit
                }
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging de l\'application...'
                sh 'mvn package -DskipTests'
            }
        }

        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                echo 'Déploiement de l\'application...'
                // Exemple de commande de déploiement (à adapter)
                sh 'scp target/monapp.jar user@serveur:/chemin/deploiement/'
                sh 'ssh user@serveur "systemctl restart monapp"'
            }
        }
    }

    post {
        success {
            echo 'Pipeline exécuté avec succès ✅'
        }
        failure {
            echo 'Échec du pipeline ❌'
        }
    }
}
