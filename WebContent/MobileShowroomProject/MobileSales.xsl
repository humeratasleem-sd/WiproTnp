<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>

            <head>

                <title>Mobile Phone Sales Summary</title>

                <style>

                    body {
                        font-family: Arial;
                    }

                    table {
                        border-collapse: collapse;
                        margin: auto;
                    }

                    th {
                        background-color: #00a9e0;
                        color: black;
                        border: 1px solid black;
                        padding: 3px;
                    }

                    td {
                        border: 1px solid black;
                        padding: 3px;
                    }

                    .high {
                        color: red;
                    }

                    h2 {
                        text-align: center;
                    }

                </style>

            </head>

            <body>

                <h2>Mobile Phone Sales Summary</h2>

                <table>

                    <tr>
                        <th>ModelID</th>
                        <th>Brand</th>
                        <th>Price</th>
                        <th>Color</th>
                        <th>SIM Size</th>
                        <th>Memory</th>
                        <th>Camera</th>
                        <th>Touch Screen</th>
                        <th>Number Sold</th>
                        <th>Store Name</th>
                    </tr>

                    <xsl:for-each select="MobileSales/Mobile">

                        <tr>

                            <td>
                                <xsl:value-of select="ModelID"/>
                            </td>

                            <td>
                                <xsl:value-of select="Brand"/>
                            </td>

                            <td>
                                <xsl:value-of select="Price"/>
                            </td>

                            <td>
                                <xsl:value-of select="Color"/>
                            </td>

                            <td>
                                <xsl:value-of select="SIMSize"/>
                            </td>

                            <td>
                                <xsl:value-of select="Memory"/>
                            </td>

                            <td>
                                <xsl:value-of select="Camera"/>
                            </td>

                            <td>
                                <xsl:value-of select="TouchScreen"/>
                            </td>

                            <xsl:choose>

                                <xsl:when test="NoSold &gt; 10">

                                    <td class="high">
                                        <xsl:value-of select="NoSold"/>
                                    </td>

                                </xsl:when>

                                <xsl:otherwise>

                                    <td>
                                        <xsl:value-of select="NoSold"/>
                                    </td>

                                </xsl:otherwise>

                            </xsl:choose>

                            <td>
                                <xsl:value-of select="storeName"/>
                            </td>

                        </tr>

                    </xsl:for-each>

                </table>

            </body>

        </html>

    </xsl:template>

</xsl:stylesheet>