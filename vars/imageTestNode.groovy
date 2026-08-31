def call(String image_name){
  try {
        sh """
            docker run --rm \
              --entrypoint sh \
              ${image_name}
        """
      } catch (err) {
          currentBuild.result = 'FAILURE'
          error("Backend unit tests failed: ${err}")
      }
}
