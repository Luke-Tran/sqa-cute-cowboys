#!/bin/bash

# Compile back-end
make

# Compile front-end
cd frontend/
make
cd ..

# Create users file and items file nessesary to run
(cat "backup_users_file.txt") > "current_user_accounts_file.txt"
(cat "backup_items_file.txt") > "available_items_file.txt"