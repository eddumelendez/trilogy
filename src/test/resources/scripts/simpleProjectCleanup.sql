BEGIN
  EXECUTE IMMEDIATE 'DROP PROCEDURE EXAMPLE_PROCEDURE';
  EXECUTE IMMEDIATE 'DROP PROCEDURE EXAMPLE$';
  EXCEPTION WHEN OTHERS THEN NULL;
END;

