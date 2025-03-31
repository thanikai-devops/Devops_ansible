//  Checkout Groovy 
def gitcheckout(String repourl, String branch, String credentialsId="BitbucketRepo") {

    echo "Checking out from repo: ${repourl}, branch: ${branch} with credentials: ${credentialsId}"
    checkout scmGit(
        branches: [[name: "*/${branch}"]],  // Use the provided branch name
        extensions: [],  // You can specify other Git options here if needed
        userRemoteConfigs: [
            [
                credentialsId: credentialsId,  // Use the provided credentials ID
                url: repourl  // Use the provided repository URL
            ]
        ]
    )
}
