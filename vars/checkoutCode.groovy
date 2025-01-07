// def call(String gitbranch , String repourl,String credentialsId = "BitbucketRepo" ) {
//     // Fetch the Git configuration based on the project
//     def gitbranch = System.getenv('GIT_BRANCH') ?: error ("GIT_BRANCH environment variable")
//     def repourl = System.getenv('GIT_URL') ?: error ("GIT_URL environment variable ")
//     checkout([
//         $class: "GitSCM",
//         branches: [[name: "*/${gitbranch}"]],
//         userRemoteConfigs: [[
//             url: repourl,
//             credentialsId: credentialsId
//         ]]
//     ])
// }
def call(String gitbranch, String repourl, String credentialsId = "BitbucketRepo") {
    // Check if gitbranch is provided; if not, use the environment variable
    if (!gitbranch) {
        gitbranch = System.getenv('GIT_BRANCH') ?: error("GIT_BRANCH environment variable is not set")
    }

    // Check if repourl is provided; if not, use the environment variable
    if (!repourl) {
        repourl = System.getenv('GIT_URL') ?: error("GIT_URL environment variable is not set")
    }

    // Checkout the specified branch from the Git repository
    checkout([
        $class: "GitSCM",
        branches: [[name: "*/${gitbranch}"]],
        userRemoteConfigs: [[
            url: repourl,
            credentialsId: credentialsId
        ]]
    ])
}
