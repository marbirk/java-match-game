#!groovy

node {
    stage("Cleanup") {
        cleanWs()
    }
    stage("Checkout") {
        checkout([
                $class: 'GitSCM', 
                branches: [[name: '*/master']], 
                doGenerateSubmoduleConfigurations: false, 
                extensions: [], 
                submoduleCfg: [], 
                userRemoteConfigs: [[url: 'https://github.com/marbirk/java-match-game']]
        ])
    }
    stage("Build") {
        def mvnHome = tool name: 'maven3', type: 'maven'
        sh "${mvnHome}/bin mvn clean package"
    }
    stage("Create new folder") {
        sh "mkdir -p output"
    }
    stage("Write new file") {
        writeFile file: "output/newFile.txt", text: "Hier steht ein wichtiger Text!"
        sh "ls"
        sh "cat output/newFile.txt"
    }
    stage("Cleanup") {
        cleanWs()
    }
}
