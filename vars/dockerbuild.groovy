// vars/build.groovy
// Environment variables
def call(String imageName,String imageTag,String dockerfilepath) {
    // Step 1: Check Docker version
    echo "Checking Docker version..."
    sh "docker --version"
    // Step 2: Build Docker image
    echo "Pulling Docker image ${imageName}:${imageTag}..."
    sh """
        docker build -t  ${imageName}/${imageTag} .
    """ 
}






// def call(String appName , String appDir ) {
//     script {
//         // Step 1: Prepare the build context directory for Docker
//         def buildContext = "./docker-context-${appName}"
        
//         // Create the build context directory
//         sh "mkdir -p ${buildContext}"

//         // Step 2: Copy the application code to the build context directory
//         sh "cp -r ${appDir}/* ${buildContext}/"

//         // Step 3: Copy the Dockerfile template to the build context
//         sh "cp resources/Dockerfile.template ${buildContext}/Dockerfile"

//         // Step 4: Build the Docker image using the prepared build context
//         def image = docker.build("${appName}-image", buildContext)

//         // Optional Step: Run the Docker container (for testing)
//         docker.image(image).run('-d -p 3000:3000')

//         // Clean up
//         sh "rm -rf ${buildContext}" // Clean up build context after the build
//     }
// }
