def call(String repo_name){
  sh """
      REPO_DIR="${repo_name}"

      if [ ! -d "\$REPO_DIR" ]; then
          echo "ERROR: Directory does not exist: \$REPO_DIR"
          exit 1

      elif [ ! -d "\$REPO_DIR/.git" ]; then
          echo "ERROR: Directory exists but is not a Git repository: \$REPO_DIR"
          exit 1

      else
          echo "Repository exists. Moving to Test stage."
      fi
  """
}
