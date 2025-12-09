from setuptools import setup, find_packages

setup(
    name='apiverve_scrabblewordscorer',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Scrabble Word Scorer is a tool for calculating Scrabble points for words. It supports multiple languages including English, French, Spanish, German, and Italian with language-specific letter values.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
