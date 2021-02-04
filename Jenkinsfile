pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                script{
                    sh """
                    ls
                    cd Development
                    ls
                    mvn clean
                    """
                }
            }
        }
    }
}
