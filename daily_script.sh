#!/bin/bash

inputs="DailyScriptInputs/*"
output="DailyScriptOutput"
datetime=`date +"%Y-%m-%d_%Hh%Mm%Ss"`
i=0

process_input_file() {
	# Make sure the output directory exists
	mkdir -p "$output"

	# For each line in the input file, feed it as user inputs into the program
	(while IFS= read -r line; do
     echo "$line"
	 done < "$1") | frontend/auction current_user_accounts_file.txt available_items_file.txt

	(cat daily_transaction_file.of.txt) > "$output/daily_transaction_file$i.of.txt"
	i=$((i+1))
}

for transaction in $inputs
do
	# If its a directory, move into it
    if [ -d "$transaction" ]
  	then
    	test_cases="$transaction/*"
        for case in $test_cases
        do
        	# If its a directory, move into it
   		 	if [ -d "$transaction" ]
   		 	then
   		 		files="$case/*"
				for file in $files
				do
					# If the file extension matches the test input format, 
					# call a function to process the file
					extension=`echo "$file" | cut -d '.' -f2`
					if [ "$extension" == "in" ]
					then
						process_input_file "$file" 
					fi
				done
   		 	fi
        done
    fi
done

for file in $output/*
do
	extension=`echo "$file" | cut -d '.' -f2`
	if [ "$extension" == "of" ]
	then
		(cat "$file") >> "$output/merged_transactions_$datetime.txt"
	fi
done
