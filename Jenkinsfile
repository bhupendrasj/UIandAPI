pipeline {

    agent any

//     stages {
//
//         stage('Clone Repository') {
//
//             steps {
//
//                 git branch: 'main',
//                 credentialsId: 'UI_API',
//                 url: 'https://github.com/bhupendrasj/UIandAPI.git'
//             }
//         }

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