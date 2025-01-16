def dockerpush(String imageName ,String imageTag ,String dockerimagename="gooplusapi"){
    // docker tagged and push into aws ecr repo
    // aws login into the aws ECR
    def tag = env.BUILD_ID
    // Tagging the docker Images 
    sh """
        docker tag ${imageName}:${imageTag} ${dockerimagename}:${tag}
    """
    //  Pushing Docker images 
    echo "docker images ${dockerimagename}:${tag}"

    sh """
        docker push ${dockerimagename}:${tag}
    """
}