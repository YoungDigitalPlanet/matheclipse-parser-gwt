/*
 * Copyright 2005-2008 Axel Kramer (axellclk@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.matheclipse.parser.client.ast;

/**
 * A node for a parsed pattern expression (i.e. x_)
 * 
 */
public class PatternNode extends ASTNode {
	private final SymbolNode fSymbol;

	private final ASTNode fConstraint;

	public PatternNode(final SymbolNode symbol, final ASTNode constraint) {
		super(null);
		fSymbol = symbol;
		fConstraint = constraint;
	}

	public ASTNode getConstraint() {
		return fConstraint;
	}

	public SymbolNode getSymbol() {
		return fSymbol;
	}

	public String toString() {
		final StringBuffer buff = new StringBuffer();
		if (fSymbol != null) {
			buff.append(fSymbol.toString());
		}
		buff.append("_");
		if (fConstraint != null) {
			buff.append(fConstraint.toString());
		}
		return buff.toString();
	}

	public boolean equals(Object obj) {
		if (obj instanceof PatternNode) {
			PatternNode pn = (PatternNode) obj;
			if (fSymbol == pn.fSymbol) {
				if (fConstraint == null || pn.fConstraint == null) {
					return fConstraint == pn.fConstraint;
				}
				return fConstraint.equals(pn.fConstraint);
			} else {
				if (fSymbol == null || pn.fSymbol == null) {
					return false;
				}
				if (fSymbol.equals(pn.fSymbol)) {
					if (fConstraint == null || pn.fConstraint == null) {
						return fConstraint == pn.fConstraint;
					}
					return fConstraint.equals(pn.fConstraint);
				}
			}
		}
		return false;
	}

	public int hashCode() {
		if (fSymbol != null) {
			fSymbol.hashCode();
		}
		return 0;
	}

}
