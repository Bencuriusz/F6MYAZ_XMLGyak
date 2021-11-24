<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Birkás Bence</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Nickname</th>
                        <th>Age</th>
                        <th>Salary</th>
                        <th>Category</th>
                    </tr>
                    <xsl:for-each select="class/student">
                        <tr>
                            <td>
                                <xsl:value-of select="@id" />
                            </td>
                            <td>
                                <xsl:value-of select="firstname" />
                            </td>
                            <td>
                                <xsl:value-of select="lastname" />
                            </td>
                            <td>
                                <xsl:value-of select="nickname" />
                            </td>
                            <td>
                                <xsl:value-of select="age" />
                            </td>
                            <td>
                                <xsl:value-of select="salary" />
                            </td>
                            <td>
                                <xsl:choose>
                                    <xsl:when test="salary &gt; 500000">High</xsl:when>
                                    <xsl:when test="salary &gt; 260000">Medium</xsl:when>
                                    <xsl:otherwise>Low</xsl:otherwise>
                                </xsl:choose>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>