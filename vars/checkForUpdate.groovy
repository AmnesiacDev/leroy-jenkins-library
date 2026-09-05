def call(String repo_dir, String test_dir, String repo_url, String branch = 'main') {

    sh """
        REPO_DIR="${repo_dir}"
        TEST_DIR="${test_dir}"
        REPO_URL="${repo_url}"
        BRANCH="${branch}"

        # Main repository does not exist
        if [ ! -d "\$REPO_DIR/.git" ]; then
            echo "Repository does not exist. Cloning..."

            git clone \
                --branch "\$BRANCH" \
                "\$REPO_URL" \
                "\$REPO_DIR"
            cp -r "\$REPO_DIR/." "\$TEST_DIR"

        else
            echo "Repository exists. Checking for updates..."

            cd "\$REPO_DIR"

            git fetch origin "\$BRANCH"

            LOCAL=\$(git rev-parse HEAD)
            REMOTE=\$(git rev-parse "origin/\$BRANCH")

            if [ "\$LOCAL" != "\$REMOTE" ]; then
                echo "New changes detected."

                git reset --hard "\$REMOTE"
                
                # Remove previous test version if it exists
                rm -rf "\$TEST_DIR"

                # Clone new version for testing
                git clone \
                    --branch "\$BRANCH" \
                    "\$REPO_URL" \
                    "\$TEST_DIR"

                echo "New repository cloned to:"
                echo "\$TEST_DIR"

            else
                echo "Repository is already up to date."
            fi
        fi
    """
}
