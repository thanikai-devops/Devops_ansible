// def call(String repourl="https://SciflareIT@bitbucket.org/dpl11-backend/goo-plus.git",String branch= "seran_dev",String credentialsId="BitbucketRepo") {
//     // Fetch the Git configuration based on the project
//     // def gitbranch = env.GIT_BRANCH ?: ""
//     // def repourl = env.REPO_URL ?: ""
//     // def credentialsId = env.credentialsId ?: "BitbucketRepo"
//     echo "Checking out from repo: ${repourl}, branch: ${branch} with credentials: ${credentialsId}"
//     checkout([
//         $class: "GitSCM",
//         branches: [[name: "*/${branch}"]],
//         userRemoteConfigs: [[
//             url: repourl,
//             credentialsId: credentialsId
//         ]]
//     ])
// }

// checkout.groovy
def checkoutFromRepo(String repourl, String branch, String credentialsId) {
    echo "Checking out from repository: ${repourl}, branch: ${branch} with credentials: ${credentialsId}"
    checkout([
        $class: 'GitSCM',
        branches: [[name: "*/${branch}"]],
        userRemoteConfigs: [[
            url: repourl,
            credentialsId: credentialsId
        ]]
    ])
}
