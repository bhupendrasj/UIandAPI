pipeline {

    agent any

    stages {

        stage('Start Docker Grid') {

            steps {

                bat 'docker compose up -d'
            }
        }

        stage('Wait For Grid') {

            steps {

                bat 'timeout /t 15'
            }
        }

        stage('Run Tests') {

            steps {

                bat 'mvn clean test'
            }
        }
    }

    post {

        always {

            bat 'docker compose down'
        }

        success {

            echo 'Execution Successful'
        }

        failure {

            echo 'Execution Failed'
        }
    }
}