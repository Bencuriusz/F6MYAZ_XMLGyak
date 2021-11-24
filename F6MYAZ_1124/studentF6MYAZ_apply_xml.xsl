<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="xml"></xsl:output>
    <xsl:template match="/">
        <html>
            <body>
                <h2>Hallgatok apple-template</h2>
                <xsl:apply-templates />
            </body>
        </html>
    </xsl:template>

    <xsl:template match="student">
        <p>
            <xsl:apply-templates select="@id" />
            <xsl:apply-templates select="firstname" />
            <xsl:apply-templates select="lastname" />
            <xsl:apply-templates select="nickname" />
            <xsl:apply-templates select="age" />
            <xsl:apply-templates select="salary" />
        </p>
    </xsl:template>

    <xsl:template match="@id">
        ID:
        <span style="color:#000000">
            <xsl:value-of select="." />
        </span>
        <br />
    </xsl:template>
    <xsl:template match="firstname">
        First name:
        <span style="color:#00FF00">
            <xsl:value-of select="." />
        </span>
        <br />
    </xsl:template>

    <xsl:template match="lastname">
        Last name:
        <span style="color:#FF0000">
            <xsl:value-of select="." />
        </span>
        <br />
    </xsl:template>

    <xsl:template match="age">
        Kor:
        <span style="color:#0000FF">
            <xsl:value-of select="." />
        </span>
        <br />
    </xsl:template>

    <xsl:template match="salary">
        Salary:
        <span style="color:#FF0000">
            <xsl:value-of select="." />
        </span>
        <br />
    </xsl:template>

</xsl:stylesheet>