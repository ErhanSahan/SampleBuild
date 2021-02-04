
pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh """
                cd Development
                mvn clean deploy
                """
            }
        }
    }
}
