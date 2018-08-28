import XCTest

final class StoryUITest: XCTestCase {
    private lazy var app: XCUIApplication = XCUIApplication()
    
    func testFeatureStorySuccessfully() {
        let story = Story(
            section: "U.S.",
            subsection: "Politics",
            title: "A Trump Endorsement Can Decide a Race. Here’s How to Get One.",
            abstract: "The president’s grip on G.O.P. primary voters is as strong as it has been since he seized the party’s nomination.",
            byline: "By JONATHAN MARTIN and MAGGIE HABERMAN",
            url: "https://www.nytimes.com/2018/08/27/us/politics/trump-endorsements.html",
            multimedia: [
                Mutlimedia(
                    url: "https://static01.nyt.com/images/2018/08/28/us/politics/28trump-endorsements1/28trump-endorsements1-thumbStandard.jpg",
                    format: .icon
                ),
                Mutlimedia(
                    url: "https://static01.nyt.com/images/2018/08/28/us/politics/28trump-endorsements1/28trump-endorsements1-thumbLarge.jpg",
                    format: .small
                ),
                Mutlimedia(
                    url: "https://static01.nyt.com/images/2018/08/28/us/politics/28trump-endorsements1/28trump-endorsements1-articleInline.jpg",
                    format: .normal
                ),
                Mutlimedia(
                    url: "https://static01.nyt.com/images/2018/08/28/us/politics/28trump-endorsements1/28trump-endorsements1-mediumThreeByTwo210.jpg",
                    format: .medium
                ),
                Mutlimedia(
                    url: "https://static01.nyt.com/images/2018/08/28/us/politics/28trump-endorsements1/28trump-endorsements1-superJumbo.jpg",
                    format: .large
                )
            ]
        )
        
        app.launch(.openStory(story))
        
        XCTAssertTrue(app.navigationBars["\(story.section) - \(story.subsection)"].isHittable)
        XCTAssertTrue(app.staticTexts[story.title].isHittable)
        XCTAssertTrue(app.staticTexts[story.abstract].isHittable)
        XCTAssertTrue(app.staticTexts[story.byline].isHittable)
        
        app.buttons["Read more..."].tap()
        
        XCTAssertTrue(app.buttons["URL"].isHittable)
        
        app.buttons["Done"].tap()
    }
}
