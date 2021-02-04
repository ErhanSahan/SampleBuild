pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                script{
                    sh """
                    cd Development
                    $Pwd
                    """
                }
            }
        }
    }
}
