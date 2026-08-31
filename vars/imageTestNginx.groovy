def call(String image_name){
  try {
        sh """
            docker run --rm ${image_name} nginx -t
        """
      } catch (err) {
          currentBuild.result = 'FAILURE'
          error("Backend unit tests failed: ${err}")
      }
}
