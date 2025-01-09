def checkoutgit(String repourl,String branch,String credentialsId="BitbucketRepo") {
    // Dynamic Checkout Branch 
    echo "Checking out from repo: ${repourl}, branch: ${branch} with credentials: ${credentialsId}"
    checkout([
        $class: "GitSCM",
        branches: [[name: "*/${branch}"]],
        userRemoteConfigs: [[
            url: repourl,
            credentialsId: credentialsId
        ]]
    ])
}


