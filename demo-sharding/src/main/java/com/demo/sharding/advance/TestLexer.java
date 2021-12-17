/*
 * <P> Copyright (c) 2021. LiQiubo.  版权所有 李秋波 </p>.
 *
 */

package com.demo.sharding.advance;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.apache.shardingsphere.sql.parser.mysql.lexer.MySQLLexer;

import java.util.Iterator;

public class TestLexer {
    public static void main(String[] args) {
        String sql = "SELECT i.* FROM t_order o" +
                " JOIN t_order_item i ON o.order_id=i.order_id" +
                " WHERE o.user_id='100' AND o.order_id=2";
        MySQLLexer lexer = new MySQLLexer(CharStreams.fromString(sql));
        Iterator<Token> iterator = (Iterator<Token>) lexer.getAllTokens().iterator();
        while (iterator.hasNext()) {
            Token token = iterator.next();
            String format = "Token start: %d, Token end: %d, TokenType: %d, Token: %s";
            String str = String.format(format,
                    token.getStartIndex(), token.getStopIndex(),
                    token.getType(), token.getText());
            System.out.println(str);
        }
    }
}
