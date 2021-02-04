pipeline {
    agent any
    tools{
     maven 'maven'  
    }
    stages {
        stage('build') {
            steps {
                script{
                    sh """
                    ls
                    cd Development
                    ls
                    mvn clean deploy
                    """
                }
            }
        }
    }
}
