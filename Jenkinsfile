pipeline {
    agent any 
    stages {
        stage('Stage 1') {
            steps {
                sh """
                cd Development
                mvn clean deploy
                """
            }
        }
    }
}
