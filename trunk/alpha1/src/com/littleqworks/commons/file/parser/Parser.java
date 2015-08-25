package com.littleqworks.commons.file.parser;

import java.io.InputStream;

public interface Parser {
	public void setInputStream(InputStream inputStream);
	public Document analyse();
}
