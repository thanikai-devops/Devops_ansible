def call(String gitbranch="seran_dev" , String repourl= "https://SciflareIT@bitbucket.org/dpl11-backend/goo-plus.git",
 String credentialsId = "BitbucketRepo" ) {
    // Fetch the Git configuration based on the project
    checkout([
        $class: "GitSCM",
        branches: [[name: "*/${gitbranch}"]],
        userRemoteConfigs: [[
            url: repourl,
            credentialsId: credentialsId
        ]]
    ])
}

