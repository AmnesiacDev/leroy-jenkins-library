def call(String image_name) {
    sh """
        docker rmi ${image_name}
    """
}
