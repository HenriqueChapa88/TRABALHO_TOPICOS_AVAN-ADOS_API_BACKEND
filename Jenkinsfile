pipeline {
    agent any

    environment {
        NETWORK_NAME = "devops_net"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Verificar Network') {
            steps {
                sh '''
                if ! docker network ls --format '{{.Name}}' | grep -w $NETWORK_NAME; then
                echo "Criando rede $NETWORK_NAME..."
                docker network create $NETWORK_NAME
                else
                echo "Rede $NETWORK_NAME já existe."
                fi
                '''
            }
        }

        stage('Build') {
            steps {
                sh '''
                docker compose build
                '''
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker compose up -d
                '''
            }
        }
    }

    post {
        success {
            echo 'Deploy realizado com sucesso!'
        }
        failure {
            echo 'Erro no pipeline!'
        }
    }

}