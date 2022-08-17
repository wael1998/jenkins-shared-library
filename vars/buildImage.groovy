#!/usr/bin/env groovy


def call(){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t wael98/demo-app:jma-2.1 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push wael98/demo-app:jma-2.1'
    }
}