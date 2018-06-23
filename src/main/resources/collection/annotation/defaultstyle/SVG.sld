            <StyledLayerDescriptor xmlns="http://www.opengis.net/sld" xmlns:ogc="http://www.opengis.net/ogc" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.0.0">
              <Name>annotation</Name>
              <Title>annotation</Title>
              <NamedLayer>
                <Name>annotation</Name>
                <UserStyle>
                  <FeatureTypeStyle>
                    <FeatureTypeName>annotation</FeatureTypeName>
                    <Rule>
                      <Name>Symbol</Name>
                      <Title>Symbol</Title>
                      <PointSymbolizer>
                        <Graphic>
                          <Mark>
                            <WellKnownName>circle</WellKnownName>
                            <Fill>
                              <CssParameter name="fill">#FF6666</CssParameter>
                            </Fill>
                            <Stroke>
                              <CssParameter name="stroke-width">10</CssParameter>
                              <CssParameter name="stroke">#FF0000</CssParameter>
                            </Stroke>
                          </Mark>
                          <Size>15</Size>
                        </Graphic>
                      </PointSymbolizer>
                    </Rule>
                    <Rule>
                      <Name>Stroke</Name>
                      <Title>Stroke</Title>
                      <LineSymbolizer>
                        <Stroke>
                          <CssParameter name="stroke-width">1</CssParameter>
                          <CssParameter name="stroke">#FF0000</CssParameter>
                        </Stroke>
                      </LineSymbolizer>
                    </Rule>
                    <Rule>
                      <Name>Text</Name>
                      <Title>Text</Title>
                      <TextSymbolizer>
                        <Label>
                          <ogc:PropertyName>Text</ogc:PropertyName>
                        </Label>
                        <Font>
                          <CssParameter name="font-weight">200</CssParameter>
                          <CssParameter name="font-family">arial</CssParameter>
                          <CssParameter name="font-style">normal</CssParameter>
                          <CssParameter name="font-size">10</CssParameter>
                        </Font>
                        <Halo>
                        </Halo>
                        <Fill>
                          <CssParameter name="fill">#000000</CssParameter>
                        </Fill>
                        <Geometry>
                          <ogc:PropertyName>Geometry</ogc:PropertyName>
                        </Geometry>
                      </TextSymbolizer>
                    </Rule>
                  </FeatureTypeStyle>
                </UserStyle>
              </NamedLayer>
            </StyledLayerDescriptor>
