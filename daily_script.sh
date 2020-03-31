#!/bin/bash

inputs="DailyScriptInputs/*"

process_input_file() {
	# $1 is the input file name given as the 1st argument. 
	# These variables extract parts of the input file path to create the output file.
	# They are local so they do not affect outside their scope.
	#local transaction=`echo "$1" | cut -d '/' -f2` 
	#local test_name=`echo "$1" | cut -d '/' -f3`
	#local output_dir="outputs/$transaction/$test_name"
	#local output_file="$output_dir/$test_name.ou.txt"
	#local expected_transactions="tests/$transaction/$test_name/$test_name.of.txt"

	# Make sure the test output file exists
	#mkdir -p "$output_dir"
	#touch "$output_file"
    #touch "$output_dir/$test_name.of.txt"
    echo "$1"

	# For each line in the input file, feed it as user inputs into the program,
	# then output the results in an appropriately named output file.
	(while IFS= read -r line; do
     echo "$line"
	 done < "$1") | frontend/auction current_user_accounts_file.txt available_items_file.txt #> "$output_file"
	#echo "$1"
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