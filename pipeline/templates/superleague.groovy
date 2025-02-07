@Library ("my_shared_library") _
pipeline {
    agent {
        label "node-1"
    }

    stage{
        stage("Build"){
            echo "Super-League_project Placed"
        }
    }
}