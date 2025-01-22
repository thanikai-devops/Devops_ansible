def dockerpush(String imageName ,String imageTag ,
String dockerimagename="829173323501.dkr.ecr.ap-south-1.amazonaws.com/gooplus:latest"){
    // docker tagged and push into aws ecr repo
    // aws login into the aws ECR
    echo "Aws ECR login"
    sh """
    aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin 829173323501.dkr.ecr.ap-south-1.amazonaws.com
    """
    def tag = env.BUILD_ID
    // Tagging the docker Images 
    sh """
        docker tag ${imageName} ${dockerimagename}
    """
    //  Pushing Docker images 
    echo "docker images ${dockerimagename}"

    sh """
        docker push ${dockerimagename}
    """

    sh "docker system prune -a "
}