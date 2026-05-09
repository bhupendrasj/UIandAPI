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

                sleep(time: 15, unit: 'SECONDS')
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