# -*- coding: utf-8 -*-
"""
Created on Mon Jul 27 17:09:42 2020
@author: Sourius
"""
import errors_and_files as imp
import math
import datetime
import random
from collections import defaultdict as dd
import pytz

def useful_functions():
    scores = [int(x) for x in input().split()]
    print(str(scores));
    print(sum(scores))
    print(len(scores))
    print(max(scores))
    print(min(scores))
    
def use_import_file_functions():
    imp.write_file()
    imp.read_file_line_by_line()
    imp.write_file_line_by_line()
    imp.read_file()

def use_math_functions():
    print(math.factorial(3));
    
def use_datetime_dunctions():
    print(datetime.date.today())
    print()
    
def generate_password(word_list):
    return random.choice(word_list) + random.choice(word_list) + random.choice(word_list)

def generate_password2(word_list):
    return ''.join(random.sample(word_list,3))    
    
def random_word_list():
    word_file = "words.txt"
    word_list = []
    
    #fill up the word_list
    with open(word_file,'r') as words:
    	for line in words:
    		# remove white space and make everything lowercase
    		word = line.strip().lower()
    		# don't include words that are too long or too short
    		if 3 < len(word) < 8:
    			word_list.append(word)
    print(generate_password(word_list))
    print(generate_password2(word_list))

def use_default_dict():
    try:
        collections.defaultdict();
    except NameError as e:
        print(e);
    dict = dd();
    dict.clear();
    dict['one']='entry 1';
    dict['two']='entry 2';
    print(dict);
    
def get_current_date_time():
    print(datetime.datetime.now(tz=pytz.utc))

if __name__ == '__main__':
    #useful_functions();
    #use_import_file_functions()
    #use_math_functions();
    #random_word_list()
    #use_default_dict();
    get_current_date_time();

