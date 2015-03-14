# Syntax of a beanprops File #

## General: ##

  * Comments start with a pound sign '#' and continue until the end of the line.
  * Identifier strings can contain the following ASCII characters: a-z, A-Z, 0-9, `_`, - (minus), . (period), `*`, $, any ASCII character in the range 160 - 255 (decimal) and any Unicode character above 255 (0u00ff).
  * Whitespace is considered to be any ASCII character in the range 0 through 32 (space).
  * The double quote character (") is used to delimit the start and end of strings. Literal strings are used to include punctuation, and other characters that WWB would normally consider tokens, inside a string. Other than this, WWB make no distinction between identifier strings and quoted strings.


## Grammar: ##

Notes: _`[ optional ]`_ denotes an optional element. **Bold** indicates a literal character or string. Semi-colons terminate a rule. "..." indicates that the preceding element can be repeated one or more times.

beanprops-file: bean ... ;

bean: beanName _`[`_ contextName _`[`_ **extends** contextName _`] ]`_ **{** parameters **}** ;

parameters: parameter _`[`_ **;** parameter _`]`_ ... ;

parameter: parameterName **:** parameterValues;

parameterValues: parameterValue _`[`_ **,** parameterValue _`]`_ ... ;

parameterValue: simpleValue _`[`_ **{** parameters **}** _`]`_ ;

beanName: _string_;
contextName: _string_;
parameterName: _string_;
simpleValue: _string_;

Note: Optionally, a trailing ';' may be specified after the last parameter in a parameterList. This is only for consistency.