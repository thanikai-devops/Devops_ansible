def call(String name = "Thanikai This is from Vars/deploy.groovy file returns") {
    script {
        sh """
            echo Hi ${name}
        """
    }
}
