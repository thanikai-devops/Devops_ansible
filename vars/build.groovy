def ecrLoginBuildAndPush(String awsRegion="ap-south-1", String ecrRepos, String buildNumber) {
    echo "Logging into AWS ECR Repository: ${ecrRepos} in region: ${awsRegion}"
    
    // Step 1: Login to AWS ECR using AWS CLI
    sh """
        aws ecr get-login-password --region ${awsRegion} | docker login --username AWS --password-stdin ${ecrRepos}
    """
    
    echo "Docker Clean up"
    sh "docker system prune -f -a"

    // Step 2: Build Docker Image
    echo "Building Docker image: ${ecrRepos}:${buildNumber}"
    sh "docker build -t ${ecrRepos}:${buildNumber} ."

    // Step 3: Push Docker Image to AWS ECR
    echo "Pushing Docker image to AWS ECR: ${ecrRepos}:${buildNumber}"
    sh "docker push ${ecrRepos}:${buildNumber}"

}
